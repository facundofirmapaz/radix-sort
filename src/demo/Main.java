package demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main
{

    public static void radixSort(int []arr)
    {
        // PROGRAMAR AQUI
        int[] salida;
        String[] cadenas = StringUtil.toStringArray(arr);

        StringUtil.lNormalize(cadenas, '0');
        
        ArrayList<Character> valoresDistintos = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            valoresDistintos.add(Character.forDigit(i, 10));

        int c = 0;
        int tope = StringUtil.maxLength(cadenas);
        String[] nuevaCadena = cadenas;
        while(c < tope)
        {
            Map<Character, ArrayList<String>> mapa = new HashMap<>();

            for(Character valor: valoresDistintos)
            {
                mapa.put(valor, new ArrayList<>());
            }

            for(String cadena: nuevaCadena)
            {
                mapa.get(cadena.charAt(tope - 1)).add(cadena);
            }

            ArrayList<String> aux = new ArrayList<>();
            for (Map.Entry<Character, ArrayList<String>> e : mapa.entrySet())
            {
                aux.addAll(e.getValue());
            }
            nuevaCadena = aux.toArray(new String[0]);
            tope--;
        }

        salida = StringUtil.toIntArray(nuevaCadena);

        for (int i = 0; i < salida.length; i++)
        {
            arr[i] = salida[i];
        }
    }

    public static void main(String[] args)
    {
        int[] arr ={16223,898,13,906,235,23,9,1532,6388,2511,8};

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }

        radixSort(arr);

        System.out.println();

        for(int i=0; i<arr.length;i++)
        {
            System.out.print(arr[i]+(i<arr.length-1?",":""));
        }
        System.out.println();

        String p = "John|Paul|George|Ringo";

        System.out.println(StringUtil.indexOfN(p, '|', 2));

    }
}
