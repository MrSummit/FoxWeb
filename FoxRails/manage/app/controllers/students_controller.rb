class StudentsController < ApplicationController
   skip_before_filter :authorize, only:[:new,:create]
  before_action :set_student, only: [:show, :edit, :update, :destroy]
  before_action :check_id,only:[:show,:edit,:update,:destroy]
  layout "users"
  
  #before_action :cheacksession
  # GET /students
  # GET /students.json
  def index
    
  end

  # GET /students/1
  # GET /students/1.json
  def show

  end

  # GET /students/new
  def new
    @student = Student.new
  end

  # GET /students/1/edit
  def edit
  end

  # POST /students
  # POST /students.json
  def create
    @student = Student.new(student_params)

    respond_to do |format|
     grade=Grade.find_by grade: params[:grade]
     if grade
      @student.grade_id=grade.id
      if @student.save
         session[:student_id]=@student.id
        format.html { render  :action=>'show',:id=>@student.id, notice: '用户创建成功' }
        format.json { render :show, status: :created, location: @student }
      else
        format.html { render :new,notice: '用户创建失败' }
        format.json { render json: @student.errors, status: :unprocessable_entity }
      end
     else 
         format.html { render :new ,notice:'班级不存在'}
        format.json { render json: @student.errors, status: :unprocessable_entity }
     end
    end
  end

  # PATCH/PUT /students/1
  # PATCH/PUT /students/1.json
  def update
    respond_to do |format|
      if @student.update(student_params)
        format.html { redirect_to student_url, notice: '信息更改成功' }
        format.json { render :show, status: :ok, location: @student }
      else
        format.html { render :edit }
        format.json { render json: @student.errors, status: :unprocessable_entity }
      end
    end
  end

  # DELETE /students/1
  # DELETE /students/1.json
  def destroy
    @student.destroy
    respond_to do |format|
      format.html { redirect_to students_url, notice: 'Student was successfully destroyed.' }
      format.json { head :no_content }
    end
  end

  private

    #判断url中的id是否为当前用户的id
    def check_id
    	sid=session[:student_id].to_s
  	id=params[:id].to_s
  	unless sid==id or session[:user_id]
  		redirect_to login_url
  	end
  end
    def set_student
      @student = Student.find(params[:id])
    end

    # Never trust parameters from the scary internet, only allow the white list through.
    def student_params
      params.require(:student).permit(:number, :name, :sex, :pswd, :year, :entrollmentTime, :orgin,:pswd_confirmation)
    end

    def getUser
  	@user=session[:user_id]
   end
end
