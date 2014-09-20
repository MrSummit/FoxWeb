class CreateCourses < ActiveRecord::Migration
  def change
    create_table :courses do |t|
      t.string :course_name
      t.string :course_id
      t.string :year
      t.string :course_begin
      t.string :course_end
      t.string :lesson_begin
      t.string :lesson_end
      t.string :course_day
      t.string :teacher
      t.string :place
      t.string :grade_id

      t.timestamps
    end
  end
end
