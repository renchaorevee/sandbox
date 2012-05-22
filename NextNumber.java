import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Driver {

	/*
	 * give a sequence, check if it's arith sequence or geo sequence
	 * return the next number in the sequence
	 * throw exception when sequence is empty, size less than 3 
	 * or doesn't math either arith sequence or geo sequence
	 */
	public static Integer guessNextNumber(List<Integer> sequence) throws Exception
	{
		if(sequence == null)
		{
			new NullPointerException("The sequence provided is null");
			return null;
		}
		else if(sequence.size() < 3)
		{
			new Exception("The sequence is too short. Sequence size is " + sequence.size());
			return null;
		}
		else
		{
			Iterator<Integer> it = sequence.iterator();
			
			boolean matchArith = true;
			boolean matchGeo = true;
			
			Integer p = it.next();
			Integer p_next = it.next();
			
			Integer q_arith = p_next - p;
			Integer q_geo = null;
			
			// for a geo sequence, if the first one is 0, 
			// all the list would be 0, the q can be any number
			if(p == 0 && p_next != 0)
				matchGeo = false;
			else if(p_next == 0)
				q_geo = 0;
			else if(p_next % p != 0)
				matchGeo = false;
			else if(p_next % p == 0)
				q_geo = p_next/p;
			
			Integer n_1 = p_next;
			Integer n = null;
			
			while(it.hasNext())
			{
				n = it.next();
				if(matchArith == true && n != n_1 + q_arith)
					matchArith = false;
				
				if(matchGeo == true && n != n_1 * q_geo)
					matchGeo = false;
				
				if(!(matchGeo && matchArith))
					new Exception("The sequence doesn't match both arith sequence and geo sequence");
				n_1 = n;
			}
			
			if(matchArith)
				return n_1 + q_arith;
			if(matchGeo)
				return n_1 * q_geo;
			
			return null;
		}
	}	

	public static void main(String[] args) {

		// test null Sequence
		List<Integer> seq = null;
		Integer n = null;
		try{
			seq= getNullTestSequence();
			n = guessNextNumber(seq);	
		}
		catch(NullPointerException e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence provided is null");
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

		// test empty Sequence
		try{
			seq= getEmptyTestSequence();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence is too short. Sequence size is 0");
		}
		
		// test Sequence with two element
		try{
			seq= getTwoElementTestSequence();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence is too short. Sequence size is 2");
		}

		// test Sequence match Arith 1
		try{
			seq= getArithTestSequence1();
			n = guessNextNumber(seq);
			assert n == 22;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

		// test Sequence match Arith 2
		try{
			seq= getArithTestSequence2();
			n = guessNextNumber(seq);
			assert n == 5;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}

		// test Sequence match Geo 1
		try{
			seq= getGeoTestSequence1();
			n = guessNextNumber(seq);
			assert n == 162;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}			
		
		// test Sequence match Geo 2
		try{
			seq= getGeoTestSequence1();
			n = guessNextNumber(seq);
			assert n == 162;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}			
		
		// test Sequence match neither 1
		try{
			seq= getMatchNothingTestSequence1();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence doesn't match both arith sequence and geo sequence");
		}

		// test Sequence match neither 2
		try{
			seq= getMatchNothingTestSequence2();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence doesn't match both arith sequence and geo sequence");
		}
		
		// test Sequence match neither 3
		try{
			seq= getMatchNothingTestSequence3();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence doesn't match both arith sequence and geo sequence");
		}
		
		// test Sequence match neither 4
		try{
			seq= getMatchNothingTestSequence4();
			n = guessNextNumber(seq);	
		}
		catch(Exception e)
		{
			assert e.getMessage().equalsIgnoreCase("The sequence doesn't match both arith sequence and geo sequence");
		}

		// test Sequence which are 0s
		try{
			seq= getAllZeroTestSequence();
			n = guessNextNumber(seq);
			assert n == 0;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}	

		// test Sequence which are 1s
		try{
			seq= getAllOneTestSequence();
			n = guessNextNumber(seq);
			assert n == 1;
		}
		catch(Exception e)
		{
			System.err.println(e);
		}	
	}
	
	public static List<Integer> getNullTestSequence()
	{
		return null;
	}
	
	public static List<Integer> getEmptyTestSequence()
	{
		return new ArrayList<Integer>();
	}
	
	public static List<Integer> getTwoElementTestSequence()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		seq.add(2);
		return seq;
	}
	
	public static List<Integer> getArithTestSequence1()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(7);
		seq.add(10);
		seq.add(13);
		seq.add(16);
		seq.add(19);
		return seq;
	}

	public static List<Integer> getArithTestSequence2()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(-5);
		seq.add(-3);
		seq.add(-1);
		seq.add(1);
		seq.add(3);
		return seq;
	}
	
	public static List<Integer> getGeoTestSequence1()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(2);
		seq.add(6);
		seq.add(18);
		seq.add(54);
		return seq;
	}

	public static List<Integer> getGeoTestSequence2()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(2);
		seq.add(-6);
		seq.add(18);
		seq.add(-54);
		return seq;
	}
	public static List<Integer> getMatchNothingTestSequence1()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		seq.add(2);
		seq.add(3);
		seq.add(5);
		return seq;
	}

	public static List<Integer> getMatchNothingTestSequence2()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		seq.add(2);
		seq.add(-3);
		seq.add(5);
		return seq;
	}
	
	public static List<Integer> getMatchNothingTestSequence3()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(0);
		seq.add(1);
		seq.add(0);
		seq.add(0);
		return seq;
	}

	public static List<Integer> getMatchNothingTestSequence4()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(0);
		seq.add(0);
		seq.add(1);
		seq.add(0);
		return seq;
	}
	
	public static List<Integer> getAllZeroTestSequence()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(0);
		seq.add(0);
		seq.add(0);
		seq.add(0);
		return seq;
	}
	
	public static List<Integer> getAllOneTestSequence()
	{
		ArrayList<Integer> seq = new ArrayList<Integer>();
		seq.add(1);
		seq.add(1);
		seq.add(1);
		seq.add(1);
		return seq;
	}
}
