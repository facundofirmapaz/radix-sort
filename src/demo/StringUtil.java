package demo;

import java.util.ArrayList;

public class StringUtil
{
    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        StringBuilder resp = new StringBuilder();

        for (int i = 0; i < n; i++)
            resp.append(c);

        return resp.toString();
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    public static String lpad(String s, int n, char c)
    {
        return replicate(c,n - s.length()) + s;
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr)
    {
        ArrayList<String> resp = new ArrayList<>();
        for (Integer cadena: arr)
        {
            resp.add(cadena.toString());
        }
        return resp.toArray(new String[0]);
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr)
    {
        int[] resp = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            resp[i] = Integer.parseInt(arr[i]);

        return resp;
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    public static int maxLength(String[] arr)
    {
        int maximo = 0;
        for (int i = 0; i < arr.length; i++)
        {
            if(arr[i].length() > arr[maximo].length())
                maximo = i;
        }
        return arr[maximo].length();
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr, char c)
    {
        int max = maxLength(arr);
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = lpad(arr[i], max, c);
        }
    }
}
