import Minor.P2.DS.BST;
import treeprinter.TreePrinter;
import java.io.FileWriter;
import java.io.IOException;

public class Test {
	private static FileWriter writer;

	public static void main(String [] args) {
		openWriter("BST_TestResults.txt");

		runTests();

		closeWriter();
	}

	static void openWriter(String fp) {
		try {
			writer = new FileWriter(fp, false);
		} catch (Exception e) {e.printStackTrace();}
	}

	static void closeWriter() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static void runTests() {
		BST<Integer> bst = new BST<Integer>();
		log("Let's try a few full BST's");
		log("bst.insert(2952): " + bst.insert(2952));
		logtree(bst);
		log(testFull(bst));
		log("bst.hasBSTProperty(): " + bst.hasBSTProperty(bst.getRoot()));

		
		log("bst.insert(1249): " + bst.insert(1249));
		log("bst.hasBSTProperty(): " + bst.hasBSTProperty(bst.getRoot()));
		log("bst.insert(5866): " + bst.insert(5866));
		logtree(bst);
		log(testFull(bst));
		
		log("Now let's make it not full.");
		log("bst.insert(491): " + bst.insert(491));
		logtree(bst);
		log(testFull(bst));
		
		log("Ok... now let's make it a bit bigger.\n");
		log("bst.insert(4786): " + bst.insert(4786));
		log("...\n");
		// insert a lot, should be balanced though
		bst.insert(6190);
		// bst.insert(5717);
		bst.insert(6061);
		// bst.insert(339);
		bst.insert(1572);
		bst.insert(6271);
		
		logtree(bst);
		log(testFull(bst));

		log("Test hasBSTProperty");
		log("bst.hasBSTProperty(): " + bst.hasBSTProperty(bst.getRoot()));

		log("\nTry to remove some things:");
		log("bst.remove(6271): " + bst.remove(6271));
		log("bst.hasBSTProperty(): " + bst.hasBSTProperty(bst.getRoot()));
		log("bst.remove(6061): " + bst.remove(6061));
		log("bst.remove(1337): " + bst.remove(1337) + "\t\tcan't fool me");
		logtree(bst);
		log(testFull(bst));

		log("bst.hasBSTProperty(): " + bst.hasBSTProperty(bst.getRoot()));


	}
	
	// static void log(String s) {
	// 	System.out.println(s);
	// }

	static void log(String s) {
		try {
			writer.write(s + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	static String testFull(BST tree) {
		return "bst is" + (String) (tree.isFull() ? " " : " not ") + "full.\n";
	}

	// static void logtree(BST tree) {
	// 	log("\nPrinting tree");
		
	// 	TreePrinter.print(tree.getRoot());
	// }

	static void logtree(BST tree) {
		try {
			TreePrinter.print(writer, tree.getRoot());
		} catch (IOException e) {
			System.out.println(e.toString());
		}
	}
}
