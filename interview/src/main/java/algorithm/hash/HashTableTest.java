package algorithm.hash;

import org.junit.Assert;
import org.junit.Test;

public class HashTableTest {

	@Test
	public void test() {
		HashTable<String> ht = new HashTable<String>();
		ht.put("a", "abc");
		ht.put("b", "abcd");

		Assert.assertEquals("abc", ht.get("a"));
		Assert.assertEquals("abcd", ht.get("b"));

		ht.put("a", "ab");
		Assert.assertEquals("ab", ht.get("a"));

	}

}
