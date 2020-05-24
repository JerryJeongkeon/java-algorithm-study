//public String solution(String[] strs) {
//      String answer = "";
//      StringBuilder sb = new StringBuilder();
//      Node root = new Node('0');
//      for (int i = 0; i < strs.length; i++) {
//         Node cnt = root;
//         for (int j = 0; j < strs[i].length(); j++) {
//            char c = strs[i].charAt(j);
//            if (!cnt.child.containsKey(c)) {
//               cnt.child.put(c, new Node(c));
//            }
//            cnt = cnt.child.get(c);
//         }
//      }
//      Node cnt =root;
//      while(true) {
//         if(cnt.child.size()==1) {
//            cnt = cnt.child.values().iterator().next();
//            sb.append(cnt.c);
//         }else {
//            break;
//         }
//      }
//      answer = sb.toString();
//      return answer;
//   }
//
//   class Node {
//      char c;
//      HashMap<Character, Node> child;
//
//      Node(char c) {
//         this.c = c;
//         this.child = new HashMap<>();
//      }
//   }