package problems;

import adt.linkedList.SingleLinkedListNode;

public class LinkedListRemoveDuplicatesImpl<T> implements LinkedListRemoveDuplicates<T>{

    /**
     * Restricoes extras:
     * - Você NÃO pode usar recursão
     * - Você pode criar métodos auxiliares se achar necessário, desde que sejam criados
     *   nesta classe
     */
    public void removeDuplicates(SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> aux = node;
        int count = 0;
        while(!node.isNIL()){
            if(!node.getNext().isNIL()){
                aux = node.getNext();
            }
            while(!aux.isNIL()){
                if(node.equals(aux)){
                    remove(count, node);
                }else{
                    count++;
                    aux = aux.getNext();
                }
            }
            count = 0;
            node = node.getNext();
        }
    }

    private void remove(int count, SingleLinkedListNode<T> node){
        SingleLinkedListNode<T> aux = node;
        while(count != 0){
            aux = aux.getNext();
            count --;
        }
        SingleLinkedListNode<T> target = aux.getNext();
        aux.setNext(target.getNext());
    }
    //Minha solução ficou n ao cubo, por isso a nota baixa, apesar de ter acertado o raciocinio, criar o método remove() foi o errado, se tivesse feito dentro do segundo while
    //Teria sido a solução certa, porra cristian.
}

