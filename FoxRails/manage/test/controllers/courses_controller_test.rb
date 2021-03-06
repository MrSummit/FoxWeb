require 'test_helper'

class CoursesControllerTest < ActionController::TestCase
  setup do
    @course = courses(:one)
  end

  test "should get index" do
    get :index
    assert_response :success
    assert_not_nil assigns(:courses)
  end

  test "should get new" do
    get :new
    assert_response :success
  end

  test "should create course" do
    assert_difference('Course.count') do
      post :create, course: { course_begin: @course.course_begin, course_day: @course.course_day, course_end: @course.course_end, course_id: @course.course_id, course_name: @course.course_name, grade_id: @course.grade_id, lesson_begin: @course.lesson_begin, lesson_end: @course.lesson_end, place: @course.place, teacher: @course.teacher, year: @course.year }
    end

    assert_redirected_to course_path(assigns(:course))
  end

  test "should show course" do
    get :show, id: @course
    assert_response :success
  end

  test "should get edit" do
    get :edit, id: @course
    assert_response :success
  end

  test "should update course" do
    patch :update, id: @course, course: { course_begin: @course.course_begin, course_day: @course.course_day, course_end: @course.course_end, course_id: @course.course_id, course_name: @course.course_name, grade_id: @course.grade_id, lesson_begin: @course.lesson_begin, lesson_end: @course.lesson_end, place: @course.place, teacher: @course.teacher, year: @course.year }
    assert_redirected_to course_path(assigns(:course))
  end

  test "should destroy course" do
    assert_difference('Course.count', -1) do
      delete :destroy, id: @course
    end

    assert_redirected_to courses_path
  end
end
