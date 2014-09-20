class SessionController < ApplicationController
skip_before_filter :authorize
  def new
  end

  def create
  	if student=Student.authenticate(params[:number],params[:pswd])
  		session[:student_id]=student.id
  		session[:student_name]=student.name
  		puts session[:grade]
  		redirect_to :action=>'show', :controller=>"students",:id=>student.id
  	else
  		redirect_to login_url,:alert=>"Invalid user/password combination"
  	end
  end

  def destroy
  	session[:student_id]=nil
  	redirect_to login_url, :alert=>"Logged out"
  end
end
