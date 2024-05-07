package student.models;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//싱글톤 관리 인스턴스, 현재id
/*

 */
public class IDGenerator {
    private static IDGenerator instance;
    private int currentId;
    private Set<Integer> allocatedIds; // 사용중인 id
    private TreeSet<Integer> freeIds; // 사용됐다가 삭제 된 id

    private IDGenerator() {
        allocatedIds = new HashSet<>();
        freeIds = new TreeSet<>();
        currentId = 1;  // ID 할당을 1부터 시작
    }

    // 인스턴스 갖기
    public static synchronized IDGenerator getInstance() {
        if (instance == null) {
            instance = new IDGenerator();
        }
        return instance;
    }

    public synchronized int generateId() {

        // 삭제된 id 확인
        if (!freeIds.isEmpty()) {
            int id = freeIds.pollFirst();
            allocatedIds.contains(id);
            return id;
        }
        //없으면 이제 새 id 사용
        while (allocatedIds.contains(currentId)) {
            currentId++;
        }
        allocatedIds.add(currentId);
        return currentId++;
    }

    //사용끝난후 해제
    public synchronized void freeId(int id) {
        if(allocatedIds.remove(id)) {
            freeIds.add(id);
        }
    }
}
