class CreateGrades < ActiveRecord::Migration
  def change
    add_column :grades, :profession, :string
    
  end
end
