package esa3;

import java.io.*;
import java.util.*;

public class HeapSort {

	/*
     * Funktion zum bauen eines Heaps 
     * 
     *  @param  arr[] wird für den Heap formatiert und an heapify() übergeben
     */
      public static void baueHeap(int arr[]){ 
    	  //länge des Arrays
    	  int size = arr.length; 
    	  //Solange i größer gleich 0 uebergebe das Array, die Laenge und den Index des Eltern-Blattes an heapify()
       		for (int i = (size / 2); i >= 0; i--) {
       			heapify(arr, size, i);
       		} 
      } 
      /*
       * Speichert den groeßten Wert aus der Wurzel in die Letzte Adresse des Arrays und übergibt
       * das Array ohne den diesen der heapify Funktion
       */
      public static void heapSort(int arr[]){
    	//Speichern der Array-Laenge
        int size = arr.length;      
        for (int i = size-1; i > 0; i--){
        	//Speichern des letzten Werts im Array
        	int s = arr[i];
        	//Groeßter Wert wird ans Ende gepackt
        	arr[i] = arr [0];
        	//uebergabe an erste Position in Array
        	arr[0] = s; 
        	//Call heapify mit dem reduzierten heap
        	heapify(arr, i, 0);
        }
      }  
      /*
       * Funtion ist für den Heap eines Teilbaums, der mit dem Knoten
       * i verwurzelt ist Bringt das Array wieder in die richtige Reihenfolge so das  arr[0] den groeßten Wert hat
       * 
       * >(Folie 94,95,96; Sortieren.PDF)<
       * @param 1 arr zu untersuchendes Array
       * @param 2 größe des Arrays
       * @param 3 position aktuell groeßten Wertes
       */
  	public static void heapify(int arr[], int size, int i) { 
  	  //initialisierung der groeßten Wurzel 
      int startNode = i;
      //initialisierung linkes Blatt 
      int linkesChild = 2 * i + 1;
      //initialisierung rechtes Blatt
      int rechtesChild = 2 * i + 2;
      
      //Überprüfe ob Blatt > als Knoten
      if (linkesChild < size && arr[linkesChild] > arr[startNode]) {
      //ersetzen
      startNode = linkesChild;                                 
      }
      if (rechtesChild < size && arr[rechtesChild] > arr[startNode]) {
      startNode = rechtesChild;                                
      }
      
      //Wenn der groeßte wert ungleich der Wurzel ist
      if (startNode != i) {
    	//Zwischenspeichern von dem Wert an Position i
        int swap = arr[i];
        //ersetzen des Wertes durch den ermittelten größeren Wert des Blattes
        arr[i] = arr[startNode];
        
        //Urspünglich groeßter wert nimmt die Position des ermittelten Wertes ein
        arr[startNode] = swap;
        
        //Rekursiver Aufruf bis Eingangswert == Ausgangswert
        heapify(arr, size, startNode);
      } 
    } 
       
  	/*
  	 * Ausgabe eines Arrays in die Konsole
  	 * @param arr Array das ausgegeben werden soll
  	 */
      public static void heapToString(int arr[]) { 
        System.out.print("Sortiertes Array: "); 
        	for (int i = 0; i < arr.length; ++i) { 
        		System.out.print(arr[i] + ", ");	
        	}  
      }      
      /*
       * Funktion zum Testen 
       * Dient primaer dazu die main uebersichtlich zu halten.
       */
      public static int[] heap(int arr[]) {
    	  baueHeap(arr); 
    	  heapSort(arr);
    	  return arr;
      } 
      
      /*
       * Funktion zum Testen 
       * Dient primaer dazu die main uebersichtlich zu halten.
       */
      public static void heapJunitTest(int arr[]) {
    	  baueHeap(arr); 
    	  heapSort(arr);
    	  heapToString(arr);
      }  
      
      /*
       * Testet den Zeitaufwand zwischen unsortierten und sortierten Arrays.
       * @param 1 Sortiertes Array Dateipfad
       * @param 2 Unsortiertes Array Dateipfad
       */
      public static void testDaten(String filePathSort , String filePathRand) {
    	  
    	  int[] arrRand= FileIntArray.FileToIntArray(filePathRand); 
    	  int[] arrSort= FileIntArray.FileToIntArray(filePathSort); 
    	    
    	  long startTimeRand= System.nanoTime();
    	  heap(arrRand);
    	  long finishTimeRand= System.nanoTime();
    	  
    	  long startTimeSort= System.nanoTime();
    	  heap(arrSort);
    	  long finishTimeSort= System.nanoTime();
    	  
    	  System.out.println("\nDauer der Durchführung RANDOM: " + (finishTimeRand-startTimeRand) + " Nano Sekunden.");
    	  System.out.println("\nDauer der Durchführung SORT: " + (finishTimeSort-startTimeSort) + " Nano Sekunden.");	  
    	  
      }
      
      //Startzeit
      static long startTime;
      //Endzeit
      static long finishTime;
      //initialisieren des Arrays
      static int[] arr = FileIntArray.FileToIntArray("src/Arrays/Rand10_1"); 
      
      public static void main(String args[]) throws IOException {  
    	  
    	  //heap(arr);
    	  //heapToString(arr);
    	  
    	 testDaten("src/Arrays/Sort100000_1","src/Arrays/Rand10_2");
      }

} 