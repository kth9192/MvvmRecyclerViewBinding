# MvvmRecyclerViewBinding

요약:
databinding 과 mvvm 패턴을 이용한 recyclerview 만들기 샘플.

- fragment에서의 recyclerview 생성

 Activity 랑 다르게 fragment 에서는 setcontentview 가 생성 불가이므로 onCreateViewHolder일때 xml을 붙여
확장(inflate) 한 view를 return 해주는 것으로 fragment view 를 생성. Activity 와 마찬가지로 뷰를 보여줄
공간이므로 recyclerview를 databinding 형식으로 생성하고 어댑터를 조립.

- recyclerview adapter의 구성

 안드로이드에서 뷰는 항상 보여줄 액티비티에서 뷰를 선언해 xml을 할당하고 
그안에 어댑터를 조립함으로 생성된다. 어댑터는 해당 뷰에서 보여줄 내용을 설정하는 것이다.

현재 recyclerview의 구성 요소는 

# onCreateViewHolder :  뷰홀더 생성
# onBindViewHolder :  뷰홀더에 요소 설정 및 실행
# getItemCount : 생성 아이템 갯수
# BindingHolder : 레이아웃의 태그안에 각 구성요소를 저장해 즉시 가져오기위해 뷰 묶음으로 만들어진 것.

- databinding & mvvm 패턴에서 view 전개

1. activity에서 view를 선언한다. 여기서는 tablayout안에 frament에서 recyclerview선언을 함.
2. 선언당시 apapter 가 조립된다. adapter 는 뷰의 내용을 설정하는 것.
3. adapter 설정 때 view 내에 정의되는 아이템의 layout이 adapter에 붙는다. databinding 설정에 따라
이 recyclerview 용 item xml 은 viewmodel 액티비티를 바인딩한다. 바인딩은 해당 액티비티의 요소들을
사용하겠다는 선언.
4. viewmodel 의 memo 요소를 사용하겠다는 아이템 xml의 설정에 따라 model 에 있는 요소를 viewmodel이 제어하면서 model 데이터를 view 로 전달

- 이전의 mvp로 했을때와 다른점 고찰

 우선 mvp 패턴은 각 요소당 인터페이스를 하나씩 달아서 설정 해주어야 했다. 각 패턴 요소의 연결고리를 인터페이스로 규제해 주어야만 서로 간섭이 없으면서
상호 필요한 것들만 주고 받는것이 가능했다. mvvm은 인터페이스가 필요없이 databinding을 이용해 서로를 잘 몰라도 binding 해놓은 설정에 따라 움직여주기 때문에 코드가 확실히 줄긴 했다.

단, 어차피 mvp도 databinding이 사용가능한데 mvvm 과 차이가 무엇인가를 생각해 보니 mvp 에서는 model 에 비즈니스 로직까지 넣어서 사용했던 반면에 아예 viewmodel 이 비즈니스로직을 가져가면서 테스트하기 용이한

구조로 변모하는 것이 차이가 아닌가 싶다. 결국 디자인 패턴은 효율적인 테스트 및 재사용을 위한 구조이기 때문에.. 

그리고 mvp는 기능당 presenter 와 model 이 각기 존재해 주어야 독립성을 지켜주는 설계가 가능했는데 (즉, 어플이 커지면 코드 크기가 상당히 비대해진다. 인터페이스 + 기능. 이래야 독립적으로 테스트를 하고 각코드를 관리하기 쉽다. 아니면 안쓰는 것과 차이가 없다.)

viewmodel 은 모델을 재사용해도 view 당 공통적으로 이용될수 있는 비즈니스 로직을 중복사용하게 된 것을 모아서 view를 다대일 연결로 하기 위해 사용하는 것이므로 재사용성이 확실히 증가할 것이다. 

다만 역으로 어플이 커지면 한페이지에 집약된 viewmodel이 갈수록 커질 것이라고 생각하는데 viewmodel을 분리 시켜서 관리한다고 쳐도 기준도 모호하고 아직은 방법이 잘 생각이 안난다.

또한 image 쪽 binding 이 나타나기 시작하면 기존과 달라 복잡해진다.
