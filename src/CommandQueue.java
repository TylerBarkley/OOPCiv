import java.util.*;

/**
 * Created by zrgam_000 on 1/31/2017.
 */
public class CommandQueue {
    Queue<Command> queue;
    LinkedList<Command> history;

    public CommandQueue(){
        queue = new LinkedList<Command>();
        history = new LinkedList<Command>();
    }

    public void carryOut(){
        queue.poll().execute();
    }

    public void add(Command command){
        queue.add(command);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public void clear(){
        queue.clear();
    }
    
    public Queue<Command> getCommandQueue() {
    	return queue;
    }
}