import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Does the insert sort stuff yayy!!!.
 *
 * @author Kevin Csiffary
 * @version 1.0
 * @since 2024-05-10
 */

// BubbleSort class
public final class InsertSort {

  /** Private constructor to prevent instantiation. */
  private InsertSort() {
    throw new UnsupportedOperationException("Cannot instantiate");
  }

  /**
   * This is the main method.
   *
   * @param args Unused
   */
  public static void main(final String[] args) {
    try {
      // Setup scanner on file.
      File file = new File("input.txt");
      Scanner sc = new Scanner(file);
      // Setup writer for output file.
      FileWriter writer = new FileWriter("output.txt");
      BufferedWriter bufferedWriter = new BufferedWriter(writer);

      while (sc.hasNextLine()) {
        // Read the line from file.
        String line = sc.nextLine();

        // Check if line is valid input.
        try {
          int[] arrLine = strToIntArr(line);
          // Call method.
          int[] sortArr = insertSort(arrLine);
          // Write to file with a new line.
          for (int i = 0; i < sortArr.length; i++) {
            bufferedWriter.write(arrLine[i] + " ");
          }
        } catch (Exception e) {
          bufferedWriter.write("Please input a number!");
        }
        bufferedWriter.newLine();
      }

      // Close all writers and scanner.
      bufferedWriter.close();
      writer.close();
      sc.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * For casting to int array.
   *
   * @param str
   * @return Integer array.
   */
  public static int[] strToIntArr(final String str) {
    String[] splitArray = str.split(" ");
    int[] array = new int[splitArray.length];

    for (int i = 0; i < splitArray.length; i++) {
      array[i] = Integer.parseInt(splitArray[i]);
    }
    return array;
  }

  /**
   * Does the insert sort stuff.
   *
   * @param arr
   * @return Returns a sorted int array.
   */
  public static int[] insertSort(final int[] arr) {
    // Loop over every element in the list.
    for (int i = 1; i < arr.length; i++) {
      // Reset temp.
      int temp = 0;
      // Go backwards through the list to place the number.
      for (int j = i; j > 0; j--) {
        // Check if the previous number is grater than the current.
        if (arr[j - 1] > arr[j]) {
          // Do the swap.
          temp = arr[j - 1];
          arr[j - 1] = arr[j];
          arr[j] = temp;
        } else {
          break;
        }
      }
    }
    // Returns the sorted array
    return arr;
  }
}
