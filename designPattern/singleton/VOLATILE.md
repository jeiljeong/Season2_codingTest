volatile 키워드에 대한 학습

참고 링크 : https://parkcheolu.tistory.com/16

 - 두 개 이상의 쓰레드가 공통 변수에 접근할 경우 메모리에서 cache로 변수값을 복사해 수정하기 때문에, 메모리 flush 이전 두 개 이상의 쓰레드가 다른 값을 가질 수 있음
 1) A 쓰레드가 Read/Write 변경, B 쓰레드가 Read를 시도 시 volatile을 사용한다면 동일한 값을 기준으로 연산하도록 유도할 수 있음
 2) A, B 쓰레드가 R/W 모두 시도한다면, volatile은 write를 보장 못함 -> 이 경우 synchronized 키워드를 통해 변수에 대한 lock을 걸어야 함
 3) volatile은 32bit, 64bit 변수에서 효과가 있으며, JAVA 1.5버전 이상에서 사용 가능
 4) synchronized를 대체할 방법은 java.util.concurrent 패키지의 AtomicLong이나 AtomicReference 타입 사용 가능
