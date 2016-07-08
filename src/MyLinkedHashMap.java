import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mitul Kapoor on 7/8/2016.
 */
public class MyLinkedHashMap {

    ArrayList<Node> nodeArrayList;
    HashMap<Integer,Integer> myHashMap;

    MyLinkedHashMap(){
        nodeArrayList = new ArrayList<>();
        myHashMap = new HashMap();
    }

    public void setNodeArrayList(ArrayList<Node> nodeArrayList) {
        this.nodeArrayList = nodeArrayList;
    }


    public void setMyHashMap(HashMap myHashMap) {
        this.myHashMap = myHashMap;
    }

    public ArrayList<Node> getNodeArrayList() {
        return nodeArrayList;
    }

    public HashMap<Integer, Integer> getMyHashMap() {
        return myHashMap;
    }

    public void searchIfAlreadyExists(Integer key){
        for(int i=0;i<nodeArrayList.size();i++){
            if(nodeArrayList.get(i).getKey() == key){
                nodeArrayList.remove(i);
            }
        }
    }

    /////declaration of my functions
    public void put(int key,int value){
        myHashMap.put(key,value);
        Object temp = myHashMap.get(key);
        Node tempNode = new Node(key,temp);
        searchIfAlreadyExists(key);
        nodeArrayList.add(tempNode);
    }

    public int get(int key){
       return (int) myHashMap.get(key);
    }

}
