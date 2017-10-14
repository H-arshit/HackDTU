class AddLocationToUnclaimed < ActiveRecord::Migration[5.1]
  def change
    add_column :unclaimeds, :location, :string
  end
end
