package org.samples;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

@Path("/export")
public class ExportFile {
    
    private static Root root;
    
    static{
    	root = new Root();
    }
    
    @GET
    @Path("/")
    public Response service() throws Exception{
    	
    	  MyDataList customers = new MyDataList();
          root.setCustomers(customers);
          System.out.println("loading done.....");
        
        final JAXBContext context = JAXBContext.newInstance(Root.class);
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
       // marshaller.
    /*      
        StreamingOutput stream = new StreamingOutput() {
            @Override
            public void write(OutputStream os) throws IOException, WebApplicationException {
               // final Writer writer = new BufferedWriter(new OutputStreamWriter(os));
                final StreamResult result = new StreamResult( os );
               // result.
                try {
                    marshaller.marshal(root, result);
                } catch (JAXBException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
              
               // writer.flush();
            }
        };*/
        
      /*  Executor executor = Executors.newSingleThreadExecutor();
        
        final PipedOutputStream source = new PipedOutputStream();
        final PipedInputStream sink = new PipedInputStream(source);
        // ...
        executor.execute(new Runnable() {
                public void run()  {
                	final StreamResult result = new StreamResult( source );
                  //  output.setByteStream(source);
                	
                    try {
                    	marshaller.marshal(root, result);
                        source.close();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }});*/
 
        ResponseBuilder responseBuilder = Response.ok(root/*sink*/);
       // responseBuilder.
        responseBuilder.type(MediaType.APPLICATION_XML);
        responseBuilder.status(200);
        return responseBuilder.build();
    }
    
    public class MyDataList implements java.util.List<Customer>{
    	
    	public static final int SIZE = 100000000;
    	private final Customer c;
       
    	
    	public MyDataList() {
    		c = new Customer();
    		c.setId(1);
    	    c.setAge(18);
    	    c.setName("Customer_");
		}

		@Override
		public int size() {
			return SIZE;
		}

		@Override
		public boolean isEmpty() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean contains(Object o) {
			return false;
		}

		@Override
		public Iterator<Customer> iterator() {
			
			return new Iterator<Customer>(){
				
				private int count;

				@Override
				public boolean hasNext() {
					++count;
					if(count%1000==0){
						System.out.println("count=" + count);
					}
					return count < SIZE;
				}

				@Override
				public Customer next() {
					// TODO Auto-generated method stub
					return c;
				}

				@Override
				public void remove() {
					// TODO Auto-generated method stub
					
				}};
		}

		@Override
		public Object[] toArray() {
			return null;
		}

		@Override
		public <T> T[] toArray(T[] a) {
			return null;
		}

		@Override
		public boolean add(Customer e) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean remove(Object o) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean containsAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(Collection<? extends Customer> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean addAll(int index, Collection<? extends Customer> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean removeAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public boolean retainAll(Collection<?> c) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public void clear() {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Customer get(int index) {
			// TODO Auto-generated method stub
			return c;
		}

		@Override
		public Customer set(int index, Customer element) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void add(int index, Customer element) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Customer remove(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public int indexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int lastIndexOf(Object o) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public ListIterator<Customer> listIterator() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public ListIterator<Customer> listIterator(int index) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Customer> subList(int fromIndex, int toIndex) {
			// TODO Auto-generated method stub
			return null;
		}

    	
    }

}
