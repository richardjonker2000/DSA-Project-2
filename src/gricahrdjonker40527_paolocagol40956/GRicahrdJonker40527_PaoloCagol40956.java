/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gricahrdjonker40527_paolocagol40956;

/**
 *
 *
 */
import java.util.Iterator;
import set.*;

public class GRicahrdJonker40527_PaoloCagol40956 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("--------------");
        System.out.println("Tree 1 created");
        System.out.println("--------------");
        
        SortedSet<Integer> tree = new TreeSet<>();
        tree.add(5);
        tree.add(10);
        tree.add(80);
        tree.add(70);
        tree.add(20);
        tree.add(50);
        tree.add(100);
        tree.add(1);

        System.out.println("Tree 1: " + tree);
        System.out.println("Tree 1 contains 10? " + tree.contains(10));
        System.out.println("Tree 1 min: " + tree.min());
        System.out.println("Tree 1 max: " + tree.max());

        System.out.println("Tree 1 subset between 0 and 10: "+tree.subSet(0, 10));
        
        System.out.println("Tree 1 subset between 50 and 100: " + tree.subSet(50, 100));
        System.out.println("Tree 1 tailset of 20: " + tree.tailSet(20));
        System.out.println("Tree 1 headset of 50: " + tree.headSet(50));
        System.out.println("Tree 1 size: " + tree.size());
        System.out.println("Tree 1 is empty: " + tree.isEmpty());
        tree.remove(20);
        System.out.println("Removed 20 from Tree 1: " + tree);
        System.out.println("--------------");
        System.out.println("Tree 2 created");
        System.out.println("--------------");

        SortedSet<Integer> tree2 = new TreeSet<>();
        tree2.add(5);
        tree2.add(10);
        tree2.add(80);
        tree2.add(70);

        System.out.println("Tree 2: " + tree2);
        System.out.println("Tree 1 contains Tree 2? " + tree.containsAll(tree2));
        tree.retainAll(tree2);
        System.out.println("Tree 1 retained with Tree 2: " + tree);
        
        System.out.println("--------------");
        System.out.println("Tree 3 created");
        System.out.println("--------------");
        
        SortedSet<Integer> tree3 = new TreeSet<>();
        tree3.add(10);
        tree3.add(40);
        tree3.add(60);
        tree3.add(30);

        System.out.println("Tree 3: " + tree3);
        System.out.println("Tree 1 contains Tree 3? " + tree.containsAll(tree3));

        tree.addAll(tree3);
        System.out.println("Tree 1 added with all of Tree 3: " + tree);

        System.out.println("--------------");
        System.out.println("Tree 4 created");
        System.out.println("--------------");
       
        SortedSet<Integer> tree4 = new TreeSet<>();
        System.out.println(tree4.equals(tree));
        System.out.println("TRee 4 min "+tree4.min());
        System.out.println("Tree 1 contains Tree 4: "+tree4.containsAll(tree));
        System.out.println("Tree 4: "+tree4);
        tree4 = tree.clone();
        System.out.println("Tree 4 after being cloned form Tree 1: "+tree4);
        System.out.println("Tree 4 equal Tree 1?: "+tree4.equals(tree));
        tree.clear();
        System.out.println("Tree 1 after clear: " + tree);
        System.out.println("Tree 4 equal Tree 1?: "+tree4.equals(tree));
        
       
         System.out.println("--------------");
        System.out.println("Tree 5 created");
        System.out.println("--------------");
       
        SortedSet<String> tree5 = new TreeSet<>();
        tree5.add("hello");
        tree5.add("bob");
        tree5.add("and");
        tree5.add("ana");
        System.out.println("Tree 5(String):"+tree5);
        
         
    }

}
