class Changegrade < ActiveRecord::Migration
  def change
  	add_column :grades, :college, :string
  end
end
