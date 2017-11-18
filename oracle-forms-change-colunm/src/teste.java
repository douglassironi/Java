import java.util.ArrayList;
import oracle.forms.jdapi.Block;
import oracle.forms.jdapi.FormModule;
import oracle.forms.jdapi.Item;
import oracle.forms.jdapi.Jdapi;
import oracle.forms.jdapi.JdapiIterator;
import oracle.forms.jdapi.JdapiModule;

public class teste {
	public static  boolean vGerar = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Inicia a JDPI do forms...
		Jdapi.setFailLibraryLoad(true);
		Jdapi.setFailSubclassLoad(true);
		try { // Tem que 
			// Chama o carinha passado no primeiro parametro.
			JdapiModule.openModule(	args[0]);
			//	 JdapiModule.openModule("l:\\ITIL10420.fmb");
			//Chama o carinha para fazer as trocas e passa como parametro o caminho do arquivo.
			trocaTamanhoColuna(new Colunas().nomes(args[1]));
			//trocaTamanhoColuna(new Colunas().nomes("l:\\colunas.txt"));


		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			// Finaliza as paradas..
			Jdapi.destroyAllModules();
			Jdapi.shutdown();
		}
	}
	//
	// Procedimento, chamado no java de metodo.... Regra para trocar o tamanho das colunas.
	//
	private static void trocaTamanhoColuna(ArrayList<String> COLUNAS) {
		try{
			for (JdapiIterator modules = Jdapi.getModules() ; modules.hasNext() ; ) {
				FormModule mod = (FormModule)(JdapiModule)modules.next();

				System.out.println("Nome do Forms: " + mod.getName());

				for (JdapiIterator blocks = mod.getBlocks() ; blocks.hasNext() ; ) {

					Block blk = (Block)blocks.next();
					System.out.println("\tBloco: " + blk.getName());

					for (JdapiIterator items = blk.getItems() ; items.hasNext() ; ) {
						Item itm = (Item)items.next();
						for (int i = 0; i < COLUNAS.size(); i++) {
							if (itm.getName().contentEquals(COLUNAS.get(i))){
								System.out.println("\t\tItem :" +itm.getName()+"Dados "+ itm.getDataType()+" Tamanho: "+ itm.getMaximumLength());
								System.out.println(" Alterando-----------"+COLUNAS.get(i) );
								vGerar = true;
								if ( itm.getDataType() == 1)
								{
									itm.setMaximumLength(15);
									itm.setFormatMask("999999999999999");
								}
								if ( itm.getDataType() == 2)
								{
									itm.setMaximumLength(15);		
								}

								System.out.println("\t\tItem :" +itm.getName()+"Dados "+ itm.getDataType()+" Tamanho: "+ itm.getMaximumLength());

							}
						}
					}
				}			
				if (vGerar) {  
					mod.save("l:\\ALTERADOS\\" +  mod.getName() );  
				}
			}    
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}





}
