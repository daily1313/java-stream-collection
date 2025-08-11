# java-stream-collection

* reference-1: https://github.com/MangKyu/stream-quiz
* reference-2: https://www.elancer.co.kr/blog/detail/255
* reference-3: https://inpa.tistory.com/entry/JCF-%F0%9F%A7%B1-Collections-Framework-%EC%A2%85%EB%A5%98-%EC%B4%9D%EC%A0%95%EB%A6%AC


## Stream

- 일련의 데이터의 흐름을 표준화된 방법으로 쉽게 가공, 처리할 수 있도록 도와주는 클래스
- 요소들의 Stream에 함수형 연산을 지원하는 클래스
- Stream API는 이러한 작업을 간편하게 수행할 수 있도록 다양한 기능을 제공할 뿐만 아니라, 병렬 처리를 통해 처리 속도를 높일 수 있습니다.
- 따라서, Collection F/W를 통해 관리하는 데이터를 처리하기 위해 주로 사용합니다.
- Stream API의 다양한 기능들은 대부분 람다를 필요로 하기 때문에 람다를 이해하고 사용할 수 있어야 합니다.

### Stream 연산

- 각 연산의 연결을 통해 파이프라인을 구성합니다.
- 파이프라인을 구성할 수 있다는 것은 스트림 대상 데이터에 대한 다양한 연산을 조합할 수 있다는 것을 의미합니다.
- 스트림을 이용한 연산 처리는 스트림 객체의 생성부터 중간 연산, 그리고 최종 연산 단계로 구분합니다.
- 스트림 객체가 제공하는 다양한 연산을 이해하고 연산에 필요한 람다표현식을 이해하고 적용하는 것이 중요합니다.

### Stream Flow

<img width="814" height="165" alt="Image" src="https://github.com/user-attachments/assets/1c2d3d99-f9db-4c95-8030-c680bab3d992" />

### Stream 생성

- 데이터의 컬렉션(집합)을 Stream으로 변환하는 과정입니다.
- Stream API를 사용하기 위해서 최초 1번 수행되어야 하며, 생성 단계에서는 모든 데이터를 한꺼번에 불러오지 않고 필요할때만 불러옵니다.
    - 이를 통해 메모리 사용량을 최적화하고 효율성이 증대됩니다.

### 가공(중간 연산)

- 가공(중간연산): 소스의 데이터 집합을 원하는 형태로 가공하는 것
    - filter, map과 같은 연산으로 Stream을 반환
    - 중간 연산은 연속에서 호출하는 메소드 체이닝으로 구현이 가능합니다.
    - 최종 연산이 실행되어야 중간연산이 처리되므로 중간연산들로만 구성된 메소드 체인은 실행되지 않습니다. (Lazy Evaluation)
    - Lazy Evaluation: 최종 연산을 호출하기 전까지 중간 연산을 지연시키는 행위

### 매핑(Map)

- 스트림 매핑(map) 연산은 스트림이 관리하는 데이터를 다른 형태의 데이터로 반환할 수 있도록 합니다.
- 매핑 연산의 메소드는 map(), mapToInt(), mapToDouble(), mapToLong()이 있습니다.
- 주로 사용하는 메소드는 map() 메소드이며 파라미터는 Function 함수형 인터페이스 입니다.
- double, int, long 기본형 데이터 타입의 데이터를 처리하기 위한 메소드들은 매핑된 값의 결과가 기본형 데이터 타입일 경우 적용하여 사용합니다.

### 가공의 종류

- filter: 필터 처리 (조건문을 통한 데이터 선별)
- map: 데이터 변환
- sorted: 정렬
- peek: 가공된 데이터를 파악하기 위한 용도
- disctinct: 중복 제거
- limit: 개수 제한

### 최종 연산

- 최종연산: Stream에 대한 최종 연산을 수행하는 것. (최종적인 목적물을 얻는 처리과정)
  - forEach, collect와 같은 연산으로 void를 반환하거나 컬렉션 타입을 반환
  - 스트림이 관리하는 전체 데이터에 대한 순회 작업은 최종 연산인 forEach() 메소드를 이용합니다.
  - collect() 메소드는 스트림 처리 이후 처리된 데이터에 대해 Collection 객체로 반환하는 메소드 입니다.
  - 스트림의 최종 연산은 forEach()와 같은 스트림 처리 결과를 바로 확인할 수 있는 연산이 있고, 데이터를 모두 소모한 이후에 그 결과를 알 수 있는 count()와 같은 연산이 있습니다.
  - 이 외에도 특정 데이터를 검색할 수 있는 allMatch(), anyMatch() 등과 같은 다양한 메소드들을 제공합니다.

### 최종 연산 종류

- forEach(): stream의 각 요소를 순회하면서 출력 등의 처리를 위해 사용합니다.
- reduce(): stream의 요소를 줄여나가면서 연산을 수행합니다.
- findFirst(), findAny():  특정 조건에 맞는 요소를 찾기 위해 사용합니다.
- anyMatch(), allMatch(), noneMatch(): 조건에 맞는지 확인을 위해 사용합니다.
- count(), min(), max(), sum(), average(): 요소의 개수, 최소(대)값, 합계, 평균을 위해 사용합니다.
- collect(): stream의 요소를 수집하여 원하는 형태로 변환하기 위해서 사용합니다.
  - toList(), toSet(), toCollection(), toArray(), toMap()

### Stream 특징

- 선언적으로 코딩이 가능합니다.
- 연속적으로 필터링, 매핑, 정렬을 체이닝으로 표현할 수 있습니다.
- 간결하고 명확한 코드로 데이터를 처리할 수 있어서 코드의 유지보수성과 가독성이 향상됩니다.
- 병렬처리를 지원합니다. (멀티스레드로 병렬처리 후 대량의 데이터를 빠르고 쉽게 처리) (parallel(), parallelStream())

## Collection

### Java Collection Framework (JCF)

- 자료 구조(Data Structure) 종류의 형태들을 자바 클래스로 구현한 모음집
- 데이터를 저장하는 자료구조와 처리하는 알고리즘을 구조화하여 클래스로 구현해둔 것

### Collection Framwork의 장점

1. 인터페이스와 다형성을 이용한 객체지향적 설계를 통해 표준화되어 있습니다.
2. 데이터 구조 및 알고리즘의 고성능 구현을 제공합니다.
3. 관련 없는 API 간의 상호 운용성을 제공합니다.
4. 이미 구현되어 있는 API를 사용하면 되기에, 새로운 API를 익히고 설계하는 시간이 줄어듭니다.
5. 소프트웨어 재사용을 촉진합니다.

### Collection Framework
<img width="819" height="477" alt="Image" src="https://github.com/user-attachments/assets/16d1f67f-74fb-47d0-9f05-03176e24a7be" />

- Collection 인터페이스
    - List, Set, Queue 인터페이스의 구현체 존재
- Map 인터페이스
    - Collection과는 별개로 Map 인터페이스의 구현체 존재

### Iterable Interface

1. 컬렉션 인터페이스들의  가장 최상의 인터페이스
2. 컬렉션들을 배우다 보면 자료들을 순회할때 이터레이터 객체를 다뤄보게 되는데, 이터레이터 객체를 관리하는 인터페이스

| 메서드                                           | 설명    |
|-----------------------------------------------|-------| 
| default void forEach(Consumer<? super T> action) | 함수형 프로그래밍 전용 루프 메서드 | 
| Iterator<T> iterator()                                        | 컬렉션에서 이터레이터 구현 |
| default Spliterator<T> splierator()                                    | 파이프라이닝 관련 메서드 | 

### Collection Interface
- List, Set, Queue를 상속하는 상위 컬렉션 타입
- 업캐스팅으로 다양한 종류의 컬렉션 자료형을 받아 자료를 crud할 수 있습니다.

<img width="664" height="266" alt="Image" src="https://github.com/user-attachments/assets/c6df3f19-a7d5-4217-a8c4-0693aa2c060d" />

| 메서드                                                           | 설명    |
|---------------------------------------------------------------|-------| 
| boolean add(Object o), boolean addAll(Collection c)           | Collection에 객체 추가 | 
| boolean contains(Object o), boolean containsAll(Collection c) | Collection에 객체들이 포함되어있는지 check |
| boolean remove(Object o), boolean removeAll(Collction c)      | Collection에서 객체 삭제 | 
| boolean retainAll(Collection c)                        | Collection에 지정한 객체를 제외한 모든 객체 삭제 | 
| void clear()                       | Collection의 모든 객체를 삭제 | 
| boolean equals(Object o)                           | 동일한 Collection인지 비교 | 
| int hashCode()                          | Collection의 hash code를 반환 | 
| boolean isEmpty()                          | Collection이 비어있는지 확인 | 
| Iterator iterator()                         | Collection의 iterator를 얻어서 반환 | 
| int size()                         | Collection에 저장된 객체의 개수를 반환 | 


### ArrayList
- 배열을 이용하여 만든 리스트
- 데이터의 저장순서가 유지되고 중복을 허용
- 데이터량에 따라 공간(capacity) 자동 설정
- 단방향 포인터 구조로 자료에 대한 순차적인 접근에 강점이 있어 조회가 빠릅니다.
  - 하지만, 삽입/삭제는 느리며, 순차적으로 추가/삭제하는 경우에는 가장 빠릅니다.

### LinkedList (삽입/삭제 성능 우수)
- 노드를 연결하여 리스트처럼 만든 컬렉션 (배열 X)
- 데이터의 중간 삽입, 삭제가 빈번할 경우 빠른 성능을 보장합니다.
- 임의 요소에 대한 조회 성능을 좋지 않습니다.
- 자바의 LinkedList는 양방향 포인터 구조로 이루어집니다.
- LinkedList는 리스트 용도 이외에도 스택, 큐, 트리 등의 자료구조의 근간이 됩니다.

### Queue
1. FIFO(First-In-First-out) 구조
2. 처음 들어온 원소가 가장 먼저 나갑니다.
3. 자바에서 Queue는 인터페이스고, 필요에 따라 큐 컬렉션을 골라서 사용할 수 있습니다.

| 메서드  | 설명 |
| --- | --- |
| boolean add(Object o) | Queue에 객체 추가 (저장공간 부족시, IllegalStateException 발생) |
| Object remove() | Queue에서 객체 반환 (없을 경우, NoSuchElementException 발생) |
| Object element() | 삭제 없이 요소를 읽어옵니다.(없을 경우, NoSuchElementException) |
| boolean offer() | Queue에 객체를 저장 |
| Object poll() | Queue에서 객체를 꺼내서 반환 (없을 경우 null 반환) |
| Object peek() | Queue에서 삭제 없이 요소를 읽어옵니다. (없을 경우 null 반환) |

### Set
<img width="488" height="134" alt="Image" src="https://github.com/user-attachments/assets/2c206c19-9a05-4778-bbf4-1de4359b3e1e" />

1. 데이터의 중복을 허용하지 않고 순서를 유지하지 않는 데이터의 집합 리스트
2. 순서 자체가 없으므로 인덱스로 객체를 검색해서 가져오는 get(index) 메서드도 존재하지 않습니다.
3. 중복 저장이 불가능하기에 심지어 null도 하나만 저장할 수 있습니다.


| 메서드 | 설명 |
| ---- | ---- |
| boolean  add(E e)	| 주어진 객체를 저장 후 true, false 리턴
| boolean contains(Object o) |	주어진 객체가 저장되었는지의 여부를 리턴
| Iterator<E> iterator() |	저장된 객체를 한번씩 가져오는 반복자를 리턴
| isEmpty()	| 컬렉션이 비었는지 여부를 검사
| int Size() |	저장되어 있는 전체 객체 수를 리턴
| void clear() |	저장된 모든 객체를 삭제
| boolean remove(Object o)	| 주어진 객체를 삭제 

#### HashSet
1. 배열과 연결노드를 결합한 자료구조 형태
2. 가장 빠른 임의 검색 접근 속도를 보장합니다.
3. 추가, 삭제, 검색, 접근성이 모두 뛰어납니다.
4. 대신 순서를 전혀 예측할 수 없습니다.

#### LinkedHashSet
1. 순서를 가지는 Set 자료구조
2. 추가된 순서 또는 가장 최근에 접근한 순서대로 접근 가능
3. 만일 중복을 제거하는 동시에 저장한 순서를 유지하고 싶다면, HashSet 대신 LinkedHashSet을 사용하면 됩니다.

#### TreeSet
1. 이진 검색 트리 (binary search tree) 자료구조 형태로 데이터 저장
2. 중복을 허용하지 않고, 순서를 가지지 않습니다.
3. 대신 데이터를 정렬하여 저장하고 있다는 특징이 있습니다.
4. 정렬, 검색, 범위 검색에 높은 성능을 가집니다.

### Map

<img width="590" height="140" alt="Image" src="https://github.com/user-attachments/assets/f05152f3-fab1-4af4-955e-73478156353c" />

- key와 value 쌍으로 연관지어 이루어진 데이터의 집합
- value는 중복해서 저장될 수 있지만, key는 고유한 값이여야 합니다.
- 기존에 데이터와 중복된 키와 값을 저장하면 기존의 값은 없어지고, 마지막에 저장된 값만 남게 됩니다.
- 저장 순서가 유지되지 않습니다.

| 추상 메서드 | 설명 |
| --- | --- |
| void clear() | Map의 모든 객체를 삭제 |
| boolean containsKey() | 지정된 key 객체와 일치하는 객체가 있는지 확인 |
| boolean containsValue() | 지정된 value 객체와 일치하는 객체가 있는지 확인 |
| Set entySet() | Map에 저장된 key-value 쌍을 Map.Entry 타입의 객체로 저장한 Set을 반환 |
| boolean equals() | 동일한 Map인지를 비교 |
| Object get() | 지정한 key 객체에 대응하는 value 객체를 반환 |
| int hashCode() | 해시 코드를 반환 |
| boolean isEmpty() | Map이 비어있는지 확인 |
| Set keySet() | Map에 저장된 모든 key 객체를 반환 |
| Object put() | Map에 저장된 key 객체와 value 객체를 연결하여 저장 |
| putAll(Map t) | 지정된 key 객체와 일치하는 key-value 쌍을 추가 |
| remove() | 지정된 key 객체와 일치하는 key-value 객체를 삭제 |
| int size() | Map에 저장된 key-value 쌍의 개수를 반환 |

#### Map.Entry 인터페이스
- Map.Entry 인터페이스는 Map 인터페이스 안에 있는 내부 인터페이스입니다.
- Map에 저장되는 key-value 쌍의 Node 내부 클래스가 이를 구현하고 있습니다.

#### HashMap

- HashTable을 보완한 컬렉션
- 배열과 연결이 결합된 Hashing 형태로, key, value를 묶어 하나의 데이터로 저장합니다.
- 중복을 허용하지 않고 순서를 보장하지 않습니다.
- key, value 값으로 null을 허용합니다.
- 추가, 삭제, 검색, 접근성이 모두 뛰어납니다.
- 비동기로 작동하기 때문에 멀티쓰레드환경에서는 어울리지 않습니다.

#### LinkedHashMap

- HashMap을 상속하고, Entry들이 연결 리스트를 구성하여 데이터의 순서를 보장합니다.
- 일반적인 Map 자료구조는 순서를 가지지 않지만, LinkedHashMap은 들어온 순서대로 순서를 가집니다.

#### TreeMap

- 이진 검색 트리의 형태로 키와 값의 쌍으로 이루어진 데이터를 저장 (TreeSet과 동일한 원리)
- TreeMap은 SortedMap 인터페이스의 구현체로서, Key값을 기준으로 정렬되는 특징을 가지고 있습니다.
- 정렬된 순서로 key/value 값을 저장하므로 조회 성능이 뛰어나지만, 저장과 동시에 정렬 과정이 일어나므로 저장 시간이 오래 걸립니다.

#### HashTable

- 자바 초기버전에 나온 클래스
- Key를 특정 해시 함수를 통해 해싱한 후 나온 결과를 배열의 인덱스로 사용하여 Value를 찾는 방식으로 동작됩니다.
- HashMap보다는 느리지만 동기화가 기본적으로 지원됩니다.
- 키와 값으로 null이 허용

#### Map Method (compute(), computeIfAbsent(), putIfAbsent(), computeIfPresent())

#### Compute()

<img width="600" height="510" alt="Image" src="https://github.com/user-attachments/assets/4cc0612a-b3b7-4bd2-9f14-7c990099b4ea" />

Key의 존재 유무와 상관없이 람다식을 수행

1. Key에 값이 존재하지 않을 경우  → null
2. Key에 값이 존재 + 람다식의 결과가 null → 해당 Key를 삭제
3. Key에 값이 존재 + 람다식의 결과가 null이 아닐 경우 → oldValue를 Key로 매핑 및 반환

#### ComputeIfAbsent()
<img width="600" height="331" alt="Image" src="https://github.com/user-attachments/assets/f5b2b2c5-a70a-404d-b1b9-1e2ead5232b7" />

Key가 존재하지 않을 경우, compute()를 실행하는 메서드

- 함수형 인터페이스이기 때문에 (key) → {} 방식으로 작성해야 합니다.
  - Key 값 존재 → 람다식 실행 X, 해당 Key에 매핑된 값을 반환합니다.
  - Key 값 존재 X → 람다식 실행 O, 람다식 수행 값을 Key에 매핑하고 반환합니다.

#### putIfAbsent()

<img width="600" height="209" alt="Image" src="https://github.com/user-attachments/assets/0d70a2b9-d1a1-4497-b0ae-e2059c404a45" />

computeIfAbsent()의 변수버전입니다.

- key에 값 존재 → 해당 key에 존재하는 기존 값을 반환
- key에 값 미존재 → value를 key에 매핑합니다. 반환값 null

#### computeIfPresent()

<img width="600" height="398" alt="Image" src="https://github.com/user-attachments/assets/d7398a53-2c03-48bd-9cb0-7633ac6d1df0" />

key가 존재할 경우에만 람다식을 수행합니다. (computeIfAbsent와 반대되는 동작)

(key, value) → {} 식의 코드로 작성합니다. (computeIfAbsent: (key) → {})

- key에 값이 존재 → 람다식을 수행하며, 람다식 수행 값을 key에 매핑하고 반환합니다.
- key에 값이 존재 X → 람다식 수행 X, Null 반환
