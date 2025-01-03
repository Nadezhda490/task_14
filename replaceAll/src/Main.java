public class Main {

//    public static char[] replaceAll(char[] original,char[] oldStr,char[] newStr)
//    реализовать этот метод используя (либо while) (либо do while)

    public static boolean contains(char[] arr, char[] search, int start) {
        int i = 0;
        while (i < search.length) {
            if (arr[i + start] != search[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static int countVxojdeniy(char[] arr, char[] search) {
        int count = 0;
        int i = 0;
        while (i <= arr.length - search.length) {
            if (contains(arr, search, i)) {
                i += search.length;
                count++;
            }
            i++;
        }
        return count;
    }

    public static int indexOf(char[] arr, char[] search, int start) {
        int i = start;
        while (i <= arr.length - search.length) {
            if (contains(arr, search, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public static char[] replaceAll(char[] original, char[] oldStr, char[] newStr) {
        int countEnter = countVxojdeniy(original, oldStr);
        if (countEnter == 0) {
            return original;
        }
        int newSize = original.length - (oldStr.length * countEnter) + (newStr.length * countEnter);
        char[] result = new char[newSize];
        int startIndex = 0;
        int findIndex = 0;
        int resultIndex = 0;
        while ((findIndex = indexOf(original, oldStr, startIndex)) != -1) {
            result = arrayCopy(original, startIndex, result, resultIndex, findIndex - startIndex);
            resultIndex += findIndex - startIndex;
            result = arrayCopy(newStr, 0, result, resultIndex, newStr.length);
            resultIndex += newStr.length;
            startIndex = findIndex + oldStr.length;
        }
        result = arrayCopy(original, startIndex, result, resultIndex, original.length - startIndex);
        return result;
    }

    public static char[] arrayCopy(char[] str, int strIndex, char[] dest, int destIndex, int leng) {
        int i = 0;
        while (i < leng) {
            dest[destIndex + i] = str[strIndex + i];
            i++;
        }
//        do {
//            dest[destIndex + i] = str[strIndex + i];
//            i++;
//        } while (i < leng);
        return dest;
    }

    public static void main(String[] args) {
        char[] str = "Привет, Надя. Как твои дела, Надя? Пошли гулять, Надя.".toCharArray();
        char[] search = "Надя".toCharArray();
        char[] old = "Мили".toCharArray();
        System.out.print("Моя функция => ");
        char[] result = replaceAll(str, search, old);
        int i = 0;
        while (i < result.length) {
            System.out.print(result[i]);
            i++;
        }
        System.out.println();
        String original = "Привет, Надя. Как твои дела, Надя? Пошли гулять, Надя.";
//        original = original.replaceAll("Надя", "Мили");
        System.out.println("Оригинал => " + original);

    }
}