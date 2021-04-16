/**
 * 
 */
package lab4;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * @author Zheng
 *
 */
public class FileDict
{

	LinkedList<MyFile> filelst = new LinkedList<MyFile>();

	/**
	 * Add the file to the beginning of the list
	 * 
	 * @param file
	 *            - the file to be added
	 * @return false - if the file with the same name is already existed; true - the
	 *         file added successfully
	 * 
	 */
	public boolean add(MyFile file)
	{
		if (filelst.contains(file))
		{
			return false;
		}
		filelst.addFirst(file);
		return true;
	}

	/**
	 * Remove the least recently added or accessed file
	 * 
	 * @param -
	 *            the given file name
	 * 
	 */
	public MyFile remove()
	{
		MyFile fileToRemove = filelst.getLast();
		filelst.removeLast();
		return fileToRemove;
	}

	/**
	 * Access a file with given filename,
	 * 
	 * @param filename
	 *            - the name of the file to access
	 * @return the file accessed, or null if no such file exists
	 */
	public MyFile access(String filename)
	{
		for (int index = 0; index < filelst.size(); index++)
		{
			MyFile file = filelst.get(index);

			if (file.getFileName().equals(filename))
			{
				MyFile accessedFile = file;
				filelst.remove(index);
				filelst.addFirst(accessedFile);
				return accessedFile;
			}
		}
		return null;
	}

	/**
	 * This method return the least recently used file, i.e. the file has not been
	 * accessed/used for the longest time Should be done in O(1) time cost
	 * 
	 * @return the least recently used file; or null if empty list
	 */
	public MyFile lruFile()
	{
		return filelst.getLast();
	}

	public String display()
	{
		return filelst.toString();
	}

	/**
	 * Extra Credit question (5%) Re-oder the files based on priorities, higher
	 * priority file placed first; ties are broken by filename in alphabetical order
	 * Hint: You may need to add CompareTo function in MyFile Class
	 */
	public void reoderFiles()
	{
		// TO-DO

	}

}