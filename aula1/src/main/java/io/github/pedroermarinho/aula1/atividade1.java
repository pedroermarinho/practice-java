package io.github.pedroermarinho.aula1;

import java.util.*;

/// Escreva um programa que carregue dois valores A e B pelo teclado e
/// imprima todos os números ímpares entre A e B.
public class atividade1 {

    static  public int removeDuplicates(int[] nums) {

        Set<Integer> numsList = new HashSet<>();

        for (var i: nums){
            numsList.add(i);
        }

        return numsList.size()+1;
    }

    public static void main(String[] args) {

        int[] nums = {1,1,2};
        int k = removeDuplicates(nums);

        System.out.println("nums:" + Arrays.toString(nums));
        System.out.println("k:" + k);
    }



}
