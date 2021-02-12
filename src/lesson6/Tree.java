package lesson6;

public class Tree {
    public Node root;


    public void insert(Person person){

        Node currentNode = new Node(person);
        if (root == null){
            root = currentNode;
            return;
        }
        Node parent = root;
        while (true){
            if (parent.currentPerson.id > currentNode.currentPerson.id){
                if (parent.leftChildren != null){
                    parent = parent.leftChildren;
                }
                else {
                        parent.leftChildren = currentNode;
                        return;
                     }
            }
            if (parent.currentPerson.id < currentNode.currentPerson.id){
                if(parent.rightChildren != null){
                    parent = parent.rightChildren;
                } else {
                    parent.rightChildren = currentNode;
                    return;
                }
            }
        }
    }
    public Node find(int id){
        Node currentNode = root;
       while (currentNode != null){
             if (currentNode.currentPerson.id == id){
                 return currentNode;
             }
             if(currentNode.currentPerson.id > id){
                 currentNode = currentNode.leftChildren;
             }
             if (currentNode.currentPerson.id < id){
                 currentNode = currentNode.rightChildren;
             }
       }
       return null;
    }

    public  Node minNode(){
        Node current = root;
        while (current != null){
            if (current.leftChildren != null)  current = current.leftChildren;
            else return current;
        }
        return null;
    }

    public  Node maxNode(){
        Node current = root;
        while (current != null){
            if(current.rightChildren != null) current = current.rightChildren;
            else  return current;
        }
        return null;
    }

    public void display(Node root){
        Node current = root;
        if (root == null){
            return;
        }
        display(current.leftChildren);
        root.show();
        display(current.rightChildren);
    }

    public boolean delete(int id){
      Node current = root;
      Node parent = null;
      boolean isLeft = false;
      while (current != null){
          if (current.currentPerson.id != id){
              if (current.rightChildren == null && current.leftChildren == null){
                  return false;
              }
              if (current.currentPerson.id > id){
                  parent = current;
                  isLeft = true;
                  current = current.leftChildren;
                  continue;
              }
              if (current.currentPerson.id< id){
                  parent = current;
                  isLeft = false;
                  current = current.rightChildren;
                  continue;
              }
          }
          if (current.currentPerson.id == id){
              if (isLeft){
                  if (current.leftChildren != null){
                      Node max = maxNode(current.leftChildren);
                      parent.leftChildren = max;
                      max.rightChildren = current.rightChildren;
                      max.leftChildren = current.leftChildren;
                      return true;
                  } else if(current.rightChildren != null){
                      parent.rightChildren = current.rightChildren;
                  } else {
                      parent.leftChildren = null;
                      return true;
                  }
              }  else {
                  if (current.leftChildren != null) {
                      Node max = maxNode(current.leftChildren);
                      if (parent != null){
                          parent.rightChildren = max;
                          max.leftChildren = current.rightChildren;
                          return true;
                      }

                  } else if(current.rightChildren != null){
                      parent.rightChildren = current.rightChildren;
                      return true;
                  } else {
                      parent.rightChildren = null;
                      return true;
                  }
              }
          }
      }
      return false;
    }

    private Node maxNode(Node root) {
        Node current = root;
        Node parent = null;

        while (current.rightChildren != null){
            parent = current;
            current = current.rightChildren;
        }
        if (parent != null){
            parent.rightChildren = current.leftChildren;
        }
        return current;
    }

}
