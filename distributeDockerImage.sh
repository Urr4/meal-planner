#!/bin/bash

if [ -z "$1" ]
  then
    echo "Image tag argument needed"
    exit 1
fi

echo "Tagging image version $1"
docker buildx build --platform linux/arm/v7 -t 08021986/meal-planner-be:$1 . #--push
#kubectl get pods -n dev --no-headers=true | awk '/meal-planner-be/{print $1}' | xargs kubectl delete pod -n dev