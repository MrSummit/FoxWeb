class AddClassToStudents < ActiveRecord::Migration
  def change
  	add_column :students, :class, :string
  end
end
