class CreateUsers < ActiveRecord::Migration
  def change
    create_table :users do |t|
      t.string :user
      t.string :name
      t.string :password
      t.string :power

      t.timestamps
    end
  end
end
