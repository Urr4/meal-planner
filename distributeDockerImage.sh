docker buildx build --platform linux/arm/v7 -t 08021986/meal-planner-be:v1 . --push
kubectl get pods -n dev --no-headers=true | awk '/meal-planner-be/{print $1}' | xargs kubectl delete pod -n dev