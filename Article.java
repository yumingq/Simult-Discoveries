import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;


// (references) Article object class
public class Article implements Comparable{

	//article attributes
	String title;
	int year;
	ArrayList<String> authors;	//reference article's authors
	String id;	//each reference has a unique String id in the format "ParentArticleNumber.ReferenceNumber"
	ArrayList<String> parentArticle;	//all numbers of parent articles the reference is cited in
	int parentNumber;	//unique identifying number of the parent article
	int numCited;	//number of times the reference is cited


	//constructor
	public Article(String t, int y, ArrayList<String> aut, String ID, ArrayList<String> pa, int nc, int parentNum){
		title = t.toUpperCase().trim();
		year = y;
		authors = aut;
		id = ID;
		parentArticle = pa;
		numCited = nc;		
		parentNumber = parentNum;
	}

	//used for sorting/transversing purposes
	@Override
	public int compareTo(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (o.getClass() != Article.class) {
			throw new ClassCastException();
		}
		Article other = (Article) o;
		if (other.year == this.year) {
			//does not account for articles that have the same
			//title but are inherently different
			return this.title.compareTo(other.title);
		} else if (this.year > other.year) {
			return 1;
		} else {
			return -1;
		}
	}

	//used for sorting/transversing purposes
	@Override
	public boolean equals(Object o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (o.getClass() != Article.class) {
			throw new ClassCastException();
		}
		Article other = (Article) o;
		if (other.year == this.year && other.title.equals(this.title)) {
			return true;
		} else {
			return false;
		}
	}

}

