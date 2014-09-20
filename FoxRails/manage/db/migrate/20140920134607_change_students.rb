class ChangeStudents < ActiveRecord::Migration
  def change
  	change_table :students do |t|
  		t.rename :grede_id,:grade_id
  	end
  end
end
