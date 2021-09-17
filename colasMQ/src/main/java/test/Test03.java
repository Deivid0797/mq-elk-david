package test;

public class Test03 {
	
	public static void main(String[] args) {
		String dato="nombre_instancia: test2,dato_logs: 7/12/21 21:51:29:035 BST 00000056 NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+7/13/21 22:21:53:447 BST 0000004f NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+7/13/21 22:34:12:468 BST 00000050 NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+9/7/21 0:14:05:305 BST 0000004f NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+9/7/21 16:47:49:133 BST 00000052 NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+9/7/21 18:13:07:942 BST 0000004f NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+9/8/21 22:29:37:827 BST 00000051 NGUtil$Server I   ASND0002I: Detected server test2 started on node node01+,hora_ejecucion_logs: 09/15/21 16:53:11,cod_revision_estado: Ok,res_error_rev_estado: ,estado_instancia: STOPPED,reinicio: true,hora_reinicio: 09/15/21 16:53:16,estado_final: STARTED,resultado_reinicio: OK";
		
		String[] arr1 = dato.split(",");
		
		for(int i= 0; i<arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		
		
		
	    //ASND0002I: Detected server test1 started on node node01.
	//ADMN1020I: An attempt is made to stop the {​​​​​0}​​​​​ server. (User ID = {​​​​​1}​​​​​)

		
//		String[] arr2 = arr1[1].split("\\+");
//		String iniCad = "ASND0002I";
//		String finCad = "";
//		for(int i= 0; i<arr2.length; i++) {
//				System.out.println(arr2[i]);
//				
//			}
		
		
	}

}
