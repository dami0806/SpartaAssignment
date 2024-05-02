package student.models;

//싱글톤 관리 인스턴스, 현재id
public class IDGenerator {
    private static IDGenerator instance;
    private int currentId;

    // 인스턴스 갖기
    public static IDGenerator getInstance() {
        if(instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    // 고유번호를 생성하고 반환하는 메서드
    public synchronized int generateId(){ //getCurrentId() {
        return currentId++;
    }

}
