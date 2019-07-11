package com.auxo.resources;

import org.json.simple.JSONObject;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Producer {
//    public static void main(String[] args) throws IOException {
//        Producer producer=new Producer();
//        producer.parseThis("E:\\Txt\\sample2.txt");
//
//    }
    //"E:\\Txt\\sample2.txt"
    public String findByWord(String value,String path,int det) throws IOException {
        FileReader fr = new FileReader(new File(path));
        BufferedReader br = new BufferedReader(fr);
        String s;



        while((s=br.readLine())!=null)
        {

            if(s.indexOf(value)==0)
            {
                if(det==1)
                {
                    return space(s);
                }
//                System.out.println();
////                System.out.println(s);
                return s;
            }

        }
        return  " hello.";
    }
    public String space(String value)
    {
        String temp="";
        for(int i=0;i<value.length();i++)
        {
            if(value.charAt(i)==' ')
            {


            }else
            {
                temp+=value.charAt(i);
            }
        }
        return temp;
    }
    public JSONObject  parseThis(String path) throws IOException {
            JSONObject object=new JSONObject();

            Map map=new LinkedHashMap(4);
            Producer producer=new Producer();

            String name,street,city,post,phone,addres,email;
            name=producer.findByWord("Name:",path,0);
            map.put("name",name.substring(6,name.length())   );
        Map address=new LinkedHashMap(3);
        street=producer.findByWord("Street Name:",path,0);
            address.put("street name",street.substring(12,street.length()));
            city=producer.findByWord("City:",path,0);
        address.put("city",city.substring(6,city.length()));
        post=producer.findByWord("Postal Code:",path,1);
        address.put("postatl code",post.substring(post.length()-6,post.length()));
            map.put("address",address);
            phone=producer.findByWord("Phone:",path,1);
            map.put("phone",phone.substring(phone.length()-10,phone.length()));
        if("hello"==producer.findByWord("Mail:",path,0))
        {
            email=producer.findByWord("Email Address:",path,0);
            map.put("email", email.substring(15,email.length()));

        }else
        {
            email=producer.findByWord("Mail:",path,0);
            map.put("email", email.substring(6,email.length()));
        }

        object.put("patient",map);


return object;

    }

    public void writeToFile(InputStream uploadedInputStream, String uploadedFileLocation) throws IOException {

            int read;

            final int BUFFER_LENGTH = 1024;

            final byte[] buffer = new byte[BUFFER_LENGTH];

            OutputStream out = new FileOutputStream(new File(uploadedFileLocation));

            while ((read = uploadedInputStream.read(buffer)) != -1) {

                out.write(buffer, 0, read);

            }

            out.flush();
            out.close();

        }
    }
