echo Your username?
read USERNAME

echo Your e-mail?
read EMAIL

git config --global user.name $USERNAME
git config --global user.email $EMAIL
