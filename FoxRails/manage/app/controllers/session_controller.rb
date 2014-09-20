class SessionController < ApplicationController
skip_before_filter :authorize
  def new
  end

  def create
  	jiaose=params[:jiaose]
  	if jiaose.to_i==1
  		if student=Student.authenticate(params[:number],params[:pswd])
  			session[:student_id]=student.id
  			session[:student_name]=student.name
  		     	redirect_to :action=>'show', :controller=>"students",:id=>student.id
  		else
  			redirect_to login_url,:alert=>"Invalid user/password combination"
  		end
  	else
              		if user=User.authenticate(params[:number],params[:pswd])
              			session[:user_id]=user.id
              			session[:user_name]=user.name
              			redirect_to :action=>'show', :controller=>"users",:id=>user.id
              		else
	  		redirect_to login_url,:alert=>"Invalid user/password combination"
	  	end
	 end
  end

  def destroy
  	session[:student_id]=nil
  	session[:user_id]=nil
  	redirect_to login_url, :alert=>"Logged out"
  end
end
