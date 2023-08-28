/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poo_l3_math_p13;

/**
 *
 * @author Usuario
 */
public class Funciones {
   
    
public  boolean repetido(int n, int[] nums, int generados){
boolean res  = false;
for(int i=0; i<generados; i++){
if(n==nums[i]){
res=true;
break;
}
}
return res;
}
public  void ordenar(int[]nums){
    int aux;
    for(int i=0;i<nums.length;i++)
        for(int k=i;k<nums.length;k++){
            aux=nums[i];
            nums[i]=nums[k];
            nums[k]=aux;
                    }
}
public  void mostrar(int[]nums){
 
    for(int num:nums)
        System.out.print(num+",");
}
}
            


