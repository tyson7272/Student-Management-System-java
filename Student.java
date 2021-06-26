class Student
{
		private int rno;
		private String name;
		private int s1;
		private int s2;
		private int s3;
		
		public Student()
		{
				rno = 0;
				name = null;
				s1 = 0;
				s2 = 0;
				s3 = 0;
		}
		
		public Student(int rno, String name, int s1, int s2, int s3)
		{
				this.rno = rno;
				this.name = name;
				this.s1 = s1;
				this.s2 = s2;
				this.s3 = s3;
		}
		
		public void setRno(int rno)
		{
				this.rno = rno;
		}
		
		public int getRno()
		{
				return rno;
		}
		
		public void setName(String name)
		{
				this.name = name;
		}
		
		public String getName()
		{
				return name;
		}
		
		public void sets1(int s1)
		{
				this.s1 = s1;
		}
		
		public int gets1()
		{
				return s1;
		}
		
		public void sets2(int s2)
		{
				this.s2 = s2;
		}
		
		public int gets2()
		{
				return s2;
		}
		
		public void sets3(int s3)
		{
				this.s3 = s3;
		}
		
		public int gets3()
		{
				return s3;
		}
		public String toString()
		{
			return "rno = " + rno + "\n" + "name = " + name + "\n" + "sub1 = "  + s1 + "\n" +  "sub2 = " + s2 + "\n" + "sub3 = " + s3 + "\n                      \n";
		}
}