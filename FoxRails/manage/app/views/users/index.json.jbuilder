json.array!(@users) do |user|
  json.extract! user, :id, :user, :name, :password, :power
  json.url user_url(user, format: :json)
end
