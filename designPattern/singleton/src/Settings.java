/**
 * 1. 구현
 * 1) thread safe한 싱글톤 구현 - 메서드에 synchronized 키워드 사용(lock을 이용, 성능 상 열위에 있음)
 * 2) 이른 초기화(eager initialization) - 클래스 로드+초기화 시점에 할당(쓰레드 세이프, but 메모리 사용 열위)
 * 3) double checked locking - java 1.5이상 사용 가능, instance 필드에 대해 volatile 키워드 필수, thread safe + 메서드 전체 synchronized보다 효율적임(필드 초기화 시점을 제외하고 lock이 걸리지 않음)
 * 4) static inner class - 느린 초기화 + thread safe한 방식
 */
/**
 * 2. 파훼법
 * 1) reflection
 */
public class Settings {
    private Settings() { }

    private static class SettingsHolder {
        private static final Settings INSTANCE = new Settings();
    }

    public static Settings getInstance() {
        return SettingsHolder.INSTANCE;
    }
}
