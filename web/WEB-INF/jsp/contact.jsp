<%-- 
    Document   : contact
    Created on : May 12, 2013, 7:22:21 PM
    Author     : Tanevski
--%>
  <%@include file="header.jsp" %>
   <div class="crumb_navigation">
    Navigation: <a href="home.html">Home</a> &lt; <span class="current">Contact</span>
    
    </div>     
  <%@include file="left.jsp" %>
  
 <div class="center_content">
   	<div class="center_title_bar">Contact Us</div>
    
    	<div class="prod_box_big">
        	<div class="top_prod_box_big"></div>
            <div class="center_prod_box_big">            
                 
              	<div class="contact_form">
                     <form enctype="text/plain" action="mailto:marjantanevski@gmail.com"  method="post">   
                    <div class="form_row">
                    <label class="contact"><strong>Name:</strong></label>
                    <input type="text" class="contact_input" name="name" id="name" maxlength="45"/>
                    </div>  

                    <div class="form_row">
                    <label class="contact"><strong>Email:</strong></label>
                    <input type="email" class="contact_input" name="email" id="email" maxlength="45" />
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>Phone:</strong></label>
                    <input type="tel" class="contact_input"  name="phone" id="phone" maxlength="15"/>
                    </div>
                    
                    <div class="form_row">
                    <label class="contact"><strong>Company:</strong></label>
                    <input type="text" class="contact_input" name="company" id="company" maxlength="45"/>
                    </div>


                    <div class="form_row">
                    <label class="contact"><strong>Message:</strong></label>
                    <textarea class="contact_textarea" name="message" id="message" maxlength="1000" ></textarea>
                    </div>

                    
                     <div class="form_row">
                    <button type="submit" style="border:0; background: transparent;">
                    <a href="#" class="contact">Send</a>
                    </button>
                    </div>      
                    </form> 
                </div> 
                
                                     
            </div>
            <div class="bottom_prod_box_big"></div>                                
        </div>
       
    
   
   </div><!-- end of center content -->

   
<%@include file="right.jsp" %>
<%@include file="footer.jsp" %>