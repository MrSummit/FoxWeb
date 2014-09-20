class Changes < ActiveRecord::Migration
  def change
  	change_table :students do |t|
  		t.remove :college
  	end
  end
end
