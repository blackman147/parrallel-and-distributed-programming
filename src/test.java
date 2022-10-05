import java.util.*;

public class test {


    public static void main(String[] args) {
            System.out.println("Enter size of array: ");
            Scanner sc=new Scanner(System.in);
            int n=sc.nextInt();// input size of array
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
                arr[i]= (int)(Math.random()*(n+1));// random elements in array
            int maxi=0;
            Map<Integer, Integer> mp = new HashMap<>();// frequency store
            for(int i=0;i<n;i++)
            {
                if(arr[i]>maxi)
                    maxi=arr[i];// maximum element
                if(arr[i]%2==0)// even elements only
                {
                    if (mp.containsKey(arr[i]))// key is already present
                    {
                        mp.put(arr[i], mp.get(arr[i]) + 1);
                    }
                    else// insert key
                    {
                        mp.put(arr[i], 1);
                    }
                }
            }
            System.out.println("Maximum element is "+maxi);// print maximum element
            System.out.println("Frequency of even elements is:");
            for (Map.Entry<Integer, Integer> entry : mp.entrySet())
            {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

