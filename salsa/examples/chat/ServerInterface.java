package examples.chat;

public class ServerInterface {      
                        /*
        public static void main(String[] args) {
                        String ids = ChatKt.a();
                        String[] idsInput = ids.split(" ");
                        Chat.main(idsInput);          
        }                                          
                        */
                                         
                                                                
        public static void create(String id1, String id2, String id3) {          
                Server.main(new String[] {id1, id2, id3});
        }                                                      
} 
