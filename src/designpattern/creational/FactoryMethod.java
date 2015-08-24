package designpattern.creational;

import java.util.*;

import designpattern.util.BasedPattern;

public class FactoryMethod implements BasedPattern {
	// Implement factory method instance and test two different editor class.
	@Override
	public void TestPattern() {
		FactoryMethod factory_method = new FactoryMethod();

		Editor text_editor = factory_method.getTextEditor();
		text_editor.open("Test1.txt");
		text_editor.open("Test2.txt");
		text_editor.close();

		Editor doc_editor = factory_method.getDocEditor();
		doc_editor.open("Test3.doc");
		doc_editor.close();
	}

	TextEditor getTextEditor() {
		return new TextEditor();
	}

	DocEditor getDocEditor() {
		return new DocEditor();
	}

	// Document class, declare abstract methods.
	abstract class Document {
		private String title;

		String getTitle() {
			return title;
		}

		void setTitle(String title) {
			this.title = title;
		}

		abstract void open();

		abstract void save();

		abstract void close();
	}

	// A parent Editor class, implement basic function behavior.
	abstract class Editor {
		private List<Document> docs = new ArrayList<Document>();

		void open(String file) {
			Document doc = createDocument();
			doc.setTitle(file);
			doc.open();
			docs.add(doc);
		}

		void save(Document doc) {
			doc.save();
		}

		void close(Document doc) {
			doc.close();
			docs.remove(doc);
		}

		void close() {
			while (docs.size() > 0) {
				close(docs.get(0));
			}
		}

		abstract Document createDocument(); // Factory method
	}

	// Implement abstract methods for text editor class.
	class TextEditor extends Editor {
		Document createDocument() {
			return new Document() {
				void open() {
					System.out.println("Open text file." + this.getTitle());
				}

				void save() {
					System.out.println("Save text file." + this.getTitle());
				}

				void close() {
					System.out.println("Close text file. " + this.getTitle());
				}
			};
		}
	}

	// Implement abstract methods for doc editor class.
	class DocEditor extends Editor {
		Document createDocument() {
			return new Document() {
				void open() {
					System.out.println("Open Doc file." + this.getTitle());
				}

				void save() {
					System.out.println("Save Doc file." + this.getTitle());
				}

				void close() {
					System.out.println("Close Doc file. " + this.getTitle());
				}
			};
		}
	}

}