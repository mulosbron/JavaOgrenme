package sorting;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    
    /*
        Bu algoritma, verileri karşılaştırarak ve yer değiştirerek sıralar. 
    İki ardışık öğeyi karşılaştırır ve eğer sıralama düzenine uymuyorsa 
    yer değiştirir. Bu işlem dizinin sonuna kadar tekrar eder ve 
    en büyük öğe en sona yerleşene kadar devam eder.
    */
    
    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }
    
    /*
        Bu algoritma, diziyi sıralanmış ve sıralanmamış bölgelere böler. 
    Sıralanmış bölgeyi adım adım büyüterek her öğeyi uygun konuma yerleştirir. 
    Özellikle küçük veri kümesi için etkilidir.
    */
    
    public static int[] insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
        return arr;
    }
    
    /*
        Bu algoritma, dizinin en küçük öğesini bulur ve onu sıralanmış bölgenin 
    başına ekler. Ardından, sıralanmış bölgeyi bir öğe daha büyüterek 
    işlemi tekrarlar. En küçük öğeyi seçerek sıralamayı yapar.
    */
    
    public static int[] selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    
    public static void main(String[] args) {
        
        Random random = new Random();
        int randomInt;
        int temp;
        
        int[] arr = new int[10];
        
        for (int i = 0; i < 10; i++) {
            randomInt = random.nextInt(100);
            arr[i] = randomInt;
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Bubble Sorting: " + Arrays.toString(bubbleSort(arr)));
        
        for (int i = 0; i < 10; i++) {
            randomInt = random.nextInt(10);
            temp = arr[randomInt];
            arr[randomInt] = arr[i];
            arr[i] = temp;
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Insertion Sorting: " + Arrays.toString(insertionSort(arr)));
        
        for (int i = 0; i < 10; i++) {
            randomInt = random.nextInt(10);
            temp = arr[randomInt];
            arr[randomInt] = arr[i];
            arr[i] = temp;
        }
        
        System.out.println("Array: " + Arrays.toString(arr));
        System.out.println("Selection Sorting: " + Arrays.toString(selectionSort(arr)));
    }
}

