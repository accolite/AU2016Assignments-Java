/**
 * Created by Mitul Kapoor on 7/8/2016.
 */
public class Node {
    Integer key;
    Object pointerHashMap;

    Node(Integer key, Object pointTo){
        this.key = key;
        this.pointerHashMap = pointTo;
    }

    public void setKey(Integer key) {
        this.key = key;
    }

    public void setPointerHashMap(Object pointerHashMap) {
        this.pointerHashMap = pointerHashMap;
    }

    public Integer getKey() {
        return key;
    }

    public Object getPointerHashMap() {
        return pointerHashMap;
    }
}
