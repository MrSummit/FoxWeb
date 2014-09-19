class CreateStudents < ActiveRecord::Migration
  def change
    create_table :students do |t|
      t.string :number
      t.string :name
      t.string :sex
      t.string :password
      t.string :class_id
      t.string :college
      t.string :year
      t.string :entrollmentTime
      t.string :orgin
      t.string :salt

      t.timestamps
    end
  end
end
