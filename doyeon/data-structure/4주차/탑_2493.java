// -------- 내가 다시 풀음 ~~~~~~
import java.io.*;
import java.util.Arrays;
import java.util.Stack;

class Top{
    int index;
    int height;

    Top(int index, int height){
        this.index = index;
        this.height = height;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] tops = br.readLine().split(" ");

        int[] answer = new int[n];
        
        Stack<Top> topStack = new Stack<>();
        for(int i=0; i<n; i++){
            int topHeight = Integer.parseInt(tops[i]);
            if(topStack.empty()){
                topStack.push(new Top(i, topHeight));
                continue;
            }
            while (true) {
                if(topStack.peek().height>=topHeight){
                    answer[i] = topStack.peek().index+1;
                    topStack.push(new Top(i, topHeight));
                    break;
                }
                if(topStack.peek().height<topHeight){
                    topStack.pop();
                    if(topStack.empty()){
                        topStack.push(new Top(i, topHeight));
                        answer[i] = 0;
                        break;
                    }
                }
            }
            
        }
        for(int temp: answer){
            bw.write(temp+" ");
        }
        
        bw.flush();
        bw.close();
    }
}
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.IOException;
// import java.util.Stack;

// public class 탑 {
//     public static void main(String[] args) throws IOException {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//         int n = Integer.parseInt(br.readLine());
//         String[] tops = br.readLine().split(" ");
//         int[] heights = new int[n];
//         int[] results = new int[n];
        
//         for (int i = 0; i < n; i++) {
//             heights[i] = Integer.parseInt(tops[i]);
//         }

//         Stack<Integer> stack = new Stack<>();
        
//         for (int i = 0; i < n; i++) {
//             while (!stack.isEmpty() && heights[stack.peek()] <= heights[i]) {
//                 stack.pop();
//             }
            
//             if (stack.isEmpty()) {
//                 results[i] = 0;
//             } else {
//                 results[i] = stack.peek() + 1;
//             }
            
//             stack.push(i);
//         }

//         for (int i = 0; i < n; i++) {
//             bw.write(results[i] + " ");
//         }
        
//         bw.flush();
//         bw.close();
//     }
// }